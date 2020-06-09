import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private baseUrl = 'http://localhost:9091/tasks';

  constructor(private http: HttpClient) { }

  getTask(taskId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${taskId}`);
  }

  createTask(task: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, task);
  }

  updateTask(taskId: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${taskId}`, value);
  }

  deleteTask(taskId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${taskId}`, { responseType: 'text' });
  }

  getTasksList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
