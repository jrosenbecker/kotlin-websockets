export class LoadPlaylist {
  static readonly type = '[Playlist] Load Playlist';

  constructor(public playlistId: number) { }
}
