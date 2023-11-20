import { GreetPipe } from "./greet.pipe";

describe('GreetPipe', () => {
    let systemUnderTest: GreetPipe;

    beforeEach(() => {
        // Arrange
        systemUnderTest = new GreetPipe();
    });

    describe('transform', () => {
        it('should return "Hey Hanno!" when called with "Hanno"', () => {
            // Act
            const actual = systemUnderTest.transform("Hanno");
            // Assert
            expect(actual).toBe("Hey Hanno");
        });

        it('should return "Hey hanno!" when called with "Hanno" and toLowercase set to "true"', () => {
            const actual = systemUnderTest.transform("Hanno", true);
            expect(actual).toBe('Hey hanno');
        })
    });
});