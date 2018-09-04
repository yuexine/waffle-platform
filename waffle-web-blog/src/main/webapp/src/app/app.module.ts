import { NewPostModule } from './new-post/new-post.module';
import { RouterModule } from '@angular/router';
import { PostModule } from './post/post.module';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {FormsModule} from '@angular/forms';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { NavComponent } from './common/nav/nav.component';
import { FooterComponent } from './common/footer/footer.component';

import { AppRoutingModule } from './app-routing.module';

import {MatToolbarModule} from '@angular/material/toolbar';
import { HttpClientModule } from '@angular/common/http';
import { HomeModule } from './home/home.module';
import { NewPostComponent } from './new-post/new-post.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    NavComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    FormsModule,
    HttpClientModule,
    HomeModule,
    PostModule,
    NewPostModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
