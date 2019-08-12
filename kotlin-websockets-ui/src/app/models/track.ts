import { Album } from './album';

export interface Track {
  id: number;
  name: string;
  album: Album;
}
