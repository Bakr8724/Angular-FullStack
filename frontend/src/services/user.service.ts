import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private userKey = 'user';
  constructor() { }

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

  // Clear user session data from localStorage
  clearSession(): void {
    localStorage.removeItem(this.userKey);
  }

}
