import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgxsReduxDevtoolsPluginModule } from '@ngxs/devtools-plugin';
import { NgxsModule } from '@ngxs/store';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { PlaylistResolver } from './resolvers/playlist.resolver';
import { PlaylistService } from './services/playlist.service';
import { PlaylistState } from './state/playlist/playlist.state';

@NgModule({
  declarations: [AppComponent, HomeComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    HttpClientModule,
    NgxsModule.forRoot([PlaylistState]),
    NgxsReduxDevtoolsPluginModule.forRoot()
  ],
  providers: [PlaylistService, PlaylistResolver],
  bootstrap: [AppComponent]
})
export class AppModule {}
