import { test, expect } from '@playwright/test';

test('has title', async ({ page }) => {
  await page.goto('https://playwright.dev/');

  // Expect a title "to contain" a substring.
  await expect(page).toHaveTitle(/Playwright/);
});

test('get started link', async ({ page }) => {
  await page.goto('https://playwright.dev/');

  // Click the get started link.
  await page.getByRole('link', { name: 'Get started' }).click();

  // Expects page to have a heading with the name of Installation.
  await expect(page.getByRole('heading', { name: 'Installation' })).toBeVisible();
});

test('check that the slide deck for J-Fall is up', async ({page}) => {
  await page.goto("https://hanno.codes/");

  // Click the 'Events' tab.
  await page.getByText('Events').first().click();

  // Click the 'J-Fall' slide deck button.
  await page.locator('xpath=//*[@id="main"]/article/div/section/table[3]/tbody/tr[4]/td[2]/a[3]').click();

  // Expect the header of the slide deck to contain "Pijul".
  await expect(page.getByText("Pijul").first()).toBeVisible();
})
