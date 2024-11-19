import { Component } from '@angular/core';
import { UserService } from 'src/services/user.service';
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {
  userName: string = '';
  role: string = '';

  constructor(private userService: UserService){}

  ngOnInit(){
    const user = this.userService.getUserSession();
    if(user){
      this.userName = `${user.firstName} ${user.lastName}`;
      this.role = user.role;
    }
  }
}
