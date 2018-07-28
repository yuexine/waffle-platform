import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home.component';
import { Recommend1Component } from './recommend1/recommend1.component';
import { PopularPostComponent } from './popular-post/popular-post.component';
import { Recommend2Component } from './recommend2/recommend2.component';
import { LatestPostComponent } from './latest-post/latest-post.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [
    HomeComponent,
    Recommend1Component,
    PopularPostComponent,
    Recommend2Component,
    LatestPostComponent,
  ]
})
export class HomeModule { }
