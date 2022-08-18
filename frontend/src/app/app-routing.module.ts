import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroComponent } from './components/pages/cadastro/cadastro.component';
import { CandidatasComponent } from './components/pages/candidatas/candidatas.component';
import { EmpresasComponent } from './components/pages/empresas/empresas.component';
import { HomeComponent } from './components/pages/home/home.component';
import { InstitucionalComponent } from './components/pages/institucional/institucional.component';
import { PainelCandidataComponent } from './components/pages/painel-candidata/painel-candidata.component';
import { VagasComponent } from './components/pages/vagas/vagas.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'candidatas', component: CandidatasComponent},
  {path: 'empresas', component: EmpresasComponent},
  {path: 'institucional', component: InstitucionalComponent},
  {path: 'cadastro', component: CadastroComponent},
  {path: 'vagas', component:VagasComponent},
  {path: 'painel-candidata', component:PainelCandidataComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
