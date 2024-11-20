import { Component } from '@angular/core';
import { UserService } from 'src/services/user.service';
@Component({
  selector: 'app-teams-container',
  templateUrl: './teams-container.component.html',
  styleUrls: ['./teams-container.component.css'],
})
export class TeamsContainerComponent {
  constructor(private userService: UserService) {}
  teams: any;
  ngOnInit() {
    this.userService.fetchTeams().subscribe({
      next: (teams) => {
        console.log(teams);
        this.teams = teams;
      },
      error: (err) => {
        console.error('Error fetching teams:', err);
      },
    });
    console.log(this.teams);
  }
}
