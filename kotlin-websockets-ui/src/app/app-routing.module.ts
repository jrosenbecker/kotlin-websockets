import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './components/home/home.component';
import { PlaylistResolver } from './resolvers/playlist.resolver';


const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    resolve: {
      playlist: PlaylistResolver
    }
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
