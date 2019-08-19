import { Component } from '@angular/core';
import { RxStompService } from '@stomp/ng2-stompjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  private serverUrl = 'ws://localhost:9090/ws';
  private stompClient;

  constructor(private rxStompService: RxStompService) {
    this.initializeWebSocketConnection();
  }

  initializeWebSocketConnection() {
    this.rxStompService.watch('/topic/playlist').subscribe(playlist => {
      console.log(playlist);
    })
  }
}
