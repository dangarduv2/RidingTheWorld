import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActoresComponent } from './componenteActores';



@NgModule({
  declarations: [ActoresComponent],
  imports: [
    CommonModule
  ],
  exports:[
    ActoresComponent
  ]
})
export class ActoresModule { }
