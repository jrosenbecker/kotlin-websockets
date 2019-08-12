import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Store } from '@ngxs/store';
import { Observable } from 'rxjs';
import { take } from 'rxjs/operators';

import { Playlist } from '../models/playlist';
import { LoadPlaylist } from '../state/playlist/playlist.state.actions';

@Injectable()
export class PlaylistResolver implements Resolve<Playlist> {
  constructor(private readonly store: Store) {}

  resolve(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<Playlist> {
    return this.store.dispatch(new LoadPlaylist(2)).pipe(take(1));
  }
}
