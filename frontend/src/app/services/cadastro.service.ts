import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Cadastro } from '../components/pages/cadastro/cadastro';

@Injectable({
  providedIn: 'root'
})
export class CadastroService {

  constructor(private http: HttpClient) { 

  }

  inserirCadastro(cadastro:Cadastro) : Observable<Cadastro>{
    console.log(cadastro); 
    return this.http.post<Cadastro>('http://localhost:8080/api/auth/candidato', cadastro)
  }

  carregarVagas() : Observable<any>{
    return this.http.get<any>('http://localhost:8080/api/auth/vagas')
  }
}
