interface Colored {
    color: string;

    printColor(): void
}

class Point {
}
  
class ColoredPoint extends Point implements Colored {
    color = 'blue';

    printColor(): void {
        
    }
}
