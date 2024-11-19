import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private userKey = 'user';
  constructor(private http: HttpClient) { }

  setUserSession(user: {
    id: number;
    firstName: string;
    lastName: string;
    email: string;
    role: string;
    token?: string;

  }): void {
    localStorage.setItem(this.userKey, JSON.stringify(user));
  }
  
  getUserSession():
  | {
      id: number;
      firstName: string;
      lastName: string;
      email: string;
      role: string;
      token?: string;
    }
  | null {
    const user = localStorage.getItem(this.userKey);
    return user ? JSON.parse(user) : null;
  }

  // Check if the user is logged in
  isLoggedIn(): boolean {
    return !!this.getUserSession();
  }

  // Check if the user is an admin
  isAdmin(): boolean {
    const user = this.getUserSession();
    return user?.role === 'admin';
  }

  fetchCompanies(): Observable<any[]> {
    const user = this.getUserSession();

    // If the user is an admin, fetch all companies
    if (user?.role === 'admin') {
      return this.http.get<any[]>('http://localhost:8080/company');
    }

    // If the user is a worker, fetch only the associated company
    if (user) {
      return this.http.get<any[]>(`http://localhost:8080/users/${user.id}/company`);
    }

    // Return empty array if no user is logged in
    return of([]);
  }
  setSelectedCompany(companyId: number): void {
    localStorage.setItem('selectedCompany', companyId.toString());
  }

  getSelectedCompany(): number | null {
    const companyId = localStorage.getItem('selectedCompany');
    return companyId ? parseInt(companyId, 10) : null;
  }

  // Clear user session data from localStorage
  clearSession(): void {
    localStorage.removeItem(this.userKey);
  }


}
