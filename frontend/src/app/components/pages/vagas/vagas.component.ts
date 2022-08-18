import { Component, OnInit } from '@angular/core';
import { CadastroService } from 'src/app/services/cadastro.service';
import { faClock } from '@fortawesome/free-solid-svg-icons';
import { faPersonDress } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-vagas',
  templateUrl: './vagas.component.html',
  styleUrls: ['./vagas.component.css']
})
export class VagasComponent implements OnInit {

  vagas : any;
  clockIcon = faClock;
  personIcon = faPersonDress;


  constructor(private cadastroService:CadastroService) { }

  ngOnInit(): void {
    this.carregarVagas();
  }

  carregarVagas() {
    this.cadastroService.carregarVagas().subscribe(listaVagas => {
      this.vagas = listaVagas;
      console.log(this.vagas)
    })
    
  }

}
