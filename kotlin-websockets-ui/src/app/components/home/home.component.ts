import { Component } from '@angular/core';
import { Select } from '@ngxs/store';
import { Observable } from 'rxjs';

import { Playlist } from '../../models/playlist';
import { PlaylistState } from '../../state/playlist/playlist.state';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {
  @Select(PlaylistState.getPlaylist)
  playlist$: Observable<Playlist>;
}
