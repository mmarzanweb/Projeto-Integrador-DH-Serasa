import { Component, OnInit } from '@angular/core';
import { faArrowLeftLong } from '@fortawesome/free-solid-svg-icons';
import { faArrowRightLong } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-empresa-carrossel',
  templateUrl: './empresa-carrossel.component.html',
  styleUrls: ['./empresa-carrossel.component.css']
})
export class EmpresaCarrosselComponent implements OnInit {

  setaLeft = faArrowLeftLong;
  setaRight = faArrowRightLong;


  constructor() { }

  ngOnInit(): void {
  }

}
