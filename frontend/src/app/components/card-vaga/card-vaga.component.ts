import { Component, OnInit } from '@angular/core';
import { faClock } from '@fortawesome/free-solid-svg-icons';
import { faPersonDress } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-card-vaga',
  templateUrl: './card-vaga.component.html',
  styleUrls: ['./card-vaga.component.css']
})
export class CardVagaComponent implements OnInit {

  clockIcon = faClock;
  personIcon = faPersonDress;

  constructor() { }

  ngOnInit(): void {
  }

}
