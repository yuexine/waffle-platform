import { Component, OnInit } from '@angular/core';
import { MatIconRegistry } from '@angular/material/icon';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-popular-post',
  templateUrl: './popular-post.component.html',
  styleUrls: ['./popular-post.component.scss']
})
export class PopularPostComponent implements OnInit {

  constructor(
    iconRegistry: MatIconRegistry,
     sanitizer: DomSanitizer
  ) {
    iconRegistry.addSvgIcon(
    'forward',
    sanitizer.bypassSecurityTrustResourceUrl('assets/img/forward.svg'));
    iconRegistry.addSvgIcon(
    'view',
    sanitizer.bypassSecurityTrustResourceUrl('assets/img/view.svg'));
    iconRegistry.addSvgIcon(
    'comment',
    sanitizer.bypassSecurityTrustResourceUrl('assets/img/comment.svg'));
  }

  ngOnInit() {
  }

}
