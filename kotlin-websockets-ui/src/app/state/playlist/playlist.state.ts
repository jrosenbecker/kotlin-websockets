import { Action, Selector, State, StateContext } from '@ngxs/store';
import { tap } from 'rxjs/operators';

import { PlaylistService } from '../../services/playlist.service';
import { LoadPlaylist } from './playlist.state.actions';
import { PlaylistStateModel } from './playlist.state.model';

@State<PlaylistStateModel>({
  name: 'playlist',
  defaults: {
    playlist: null
  }
})
export class PlaylistState {

  constructor(private readonly playlistService: PlaylistService) { }

  @Selector()
  static getPlaylist(state: PlaylistStateModel) {
    return state.playlist;
  }


  @Action(LoadPlaylist)
  setPlaylist(context: StateContext<PlaylistStateModel>, action: LoadPlaylist) {
    return this.playlistService.loadPlaylist(action.playlistId)
      .pipe(
        tap(playlist => context.patchState({ playlist }))
      );
  }
}
