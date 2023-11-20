import { GreetPipe } from "./greet.pipe";

describe('GreetPipe', () => {
    let systemUnderTest: GreetPipe;

    beforeEach(() => {
        systemUnderTest = new GreetPipe();
    });

    describe('transform', () => {
        it('should return "Hey Hanno!" when called with "Hanno"', () => {
            const actual = systemUnderTest.transform("Hanno");
            expect(actual).toBe("Hey Hanno!");
        });

        it('should return empty String when called with undefined', () => {
            const actual = systemUnderTest.transform(undefined);
            expect(actual).toBe('');
        });
    });
});