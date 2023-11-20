import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'greet' })
export class GreetPipe implements PipeTransform {
transform(value: string | undefined, toLowercase = false): string {
        if (!value) return '';
        return `Hey ${toLowercase ? value.toLowerCase() : value}`
    }
}