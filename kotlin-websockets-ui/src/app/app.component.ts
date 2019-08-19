import { Component } from '@angular/core';
import * as SockJS from 'sockjs-client';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  private serverUrl = 'http://localhost:9090/api/ws/playlists';
  private stompClient;

  constructor() {
    this.initializeWebSocketConnection();
  }

  initializeWebSocketConnection() {
    var sock = new SockJS(this.serverUrl);
    sock.onopen = () => { console.log('open'); };
    sock.onmessage = (message) => { console.log(message); };
    sock.onclose = () => { console.log('close'); };
  }
}
