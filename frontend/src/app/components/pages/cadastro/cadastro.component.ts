import { Component, OnInit } from '@angular/core';
import { Cadastro } from './cadastro';
import { FormGroup, FormControl } from '@angular/forms';
import { CadastroService } from 'src/app/services/cadastro.service';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})

export class CadastroComponent implements OnInit {
  cadastro = [] as any;
  formCadastro: FormGroup;
  service: any;
  

  constructor(
    private cadastroService: CadastroService
  ) { }

  ngOnInit() {
    this.createForm(new Cadastro());
  }

  createForm(cadastro: Cadastro) {
    this.formCadastro = new FormGroup({
      nome: new FormControl(cadastro.nome),
      cpf: new FormControl(cadastro.cpf),
      email: new FormControl(cadastro.email),
      senha: new FormControl(cadastro.senha),

    })
  }

  onSubmit() {
    // aqui você pode implementar a logica para fazer seu formulário salvar
    console.log("this.formCadastro: ",this.formCadastro.value)
    this.cadastro = this.formCadastro.value
    console.log("this.cadastro: ",this.cadastro)
    this.cadastroService.inserirCadastro(this.cadastro).subscribe(cad => console.log(cad))
  }

  



/*
  cadastros = [] as any;

   cadastro: Cadastro ={
    nome: "",
    cpf: 0,
    email:"",
    senha:"",
   };
 
 
 constructor(private service: CadastroService){
  this.cadastro = new Cadastro();
  
 }
  
  onSubmit(){
    this.service
    .inserirCadastro(this.cadastro)
    .subscribe( response => console.log(response));
      
  }

  ngOnInit(): void { this.cadastro }
}
*/
}

