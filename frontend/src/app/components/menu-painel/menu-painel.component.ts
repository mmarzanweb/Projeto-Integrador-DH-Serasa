import { Component, OnInit } from '@angular/core';
import { faUser } from '@fortawesome/free-solid-svg-icons';
import { faGraduationCap } from '@fortawesome/free-solid-svg-icons';
import { faStairs } from '@fortawesome/free-solid-svg-icons';
import { faCodePullRequest } from '@fortawesome/free-solid-svg-icons';
import { faPowerOff } from '@fortawesome/free-solid-svg-icons';
import { faLock } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-menu-painel',
  templateUrl: './menu-painel.component.html',
  styleUrls: ['./menu-painel.component.css']
})
export class MenuPainelComponent implements OnInit {

  dadosPessoaisIcon = faUser;
  escolaridadeIcon = faGraduationCap;
  experienciaIcon = faStairs;
  inscricoesIcon = faCodePullRequest;
  segurancaIcon = faLock;
  logoutIcon = faPowerOff;



  constructor() { }

  ngOnInit(): void {
  }

}
