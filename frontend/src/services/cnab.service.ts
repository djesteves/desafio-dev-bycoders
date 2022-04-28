import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Cnab } from "models/cnab.model";
import { Observable } from "rxjs/internal/Observable";
import { environment } from "environments/environment";
import { MessageService } from './message.service';
import { tap } from "rxjs/internal/operators/tap";
import { catchError } from "rxjs/internal/operators/catchError";
import { of } from "rxjs/internal/observable/of";
import { CnabResponse } from "models/cnabResponse.model";

@Injectable({ providedIn: 'root' })
export class CnabService {

    private url = '/v1/cnab';
    private totalUrl = '/v1/cnab/total_store';

    constructor(
        private http: HttpClient,
        private messageService: MessageService
    ) { }

    private log(message: string) {
        this.messageService.add(`CnabService: ${message}`);
      }

    public findAllStore(): Observable<Cnab[]> {
        return this.http.get<Cnab[]>(environment.apiURL + this.url)
        .pipe(
            tap(_ => this.log('fetched stores')),
            catchError(this.handleError<Cnab[]>('getStores', []))
          );
    }

    public totalStore(): Observable<CnabResponse[]> {
      return this.http.get<CnabResponse[]>(environment.apiURL + this.totalUrl)
      .pipe(
          tap(_ => this.log('fetched stores')),
          catchError(this.handleError<CnabResponse[]>('getStores', []))
        );
  }

    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
    
          // TODO: send the error to remote logging infrastructure
          console.error(error); // log to console instead
    
          // TODO: better job of transforming error for user consumption
          this.log(`${operation} failed: ${error.message}`);
    
          // Let the app keep running by returning an empty result.
          return of(result as T);
        };
      }
}