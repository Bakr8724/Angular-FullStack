import { Component } from '@angular/core';
import { UserService } from 'src/services/user.service';
import { Route, Router } from '@angular/router';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent {
  constructor(public userService: UserService, public router: Router) {}
  logout() {
    this.userService.clearSession();
    this.router.navigate(['/login']);
  }
}
