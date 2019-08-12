import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Store } from '@ngxs/store';
import { Observable } from 'rxjs';

import { environment } from '../../environments/environment';
import { Playlist } from '../models/playlist';

@Injectable()
export class PlaylistService {
  constructor(private readonly http: HttpClient, private readonly store: Store) { }

  loadPlaylist(id: number): Observable<Playlist> {
    return this.http.get<Playlist>(`${environment.apiDomain}/api/playlists/${id}`);

  }
}
