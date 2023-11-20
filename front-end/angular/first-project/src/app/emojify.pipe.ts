import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'emojify' })
export class EmojifyPipe implements PipeTransform {
    transform(value: string | undefined): string {
        if (!value) return '';
        return `😎😎😎😎 ${value} 😎😎😎😎`
    }
}