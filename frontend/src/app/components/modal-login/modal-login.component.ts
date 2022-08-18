import { Component, OnInit } from '@angular/core';
import { faSquareXmark } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-modal-login',
  templateUrl: './modal-login.component.html',
  styleUrls: ['./modal-login.component.css']
})
export class ModalLoginComponent implements OnInit {

  closeIcon = faSquareXmark;
  constructor() { }

  ngOnInit(): void {
  }

}
