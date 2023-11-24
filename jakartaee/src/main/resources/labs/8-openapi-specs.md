# LAB 8: OpenAPI Specs

Now we want to add OpenAPI documentation, so that our end users can understand our REST API without having to read Java code.

1. Follow the tutorial at https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Getting-started. (start at "Quick start")
2. Make sure the OpenAPI spec is displayed when you navigate to `<server_url>/<application_path>/openapi.yaml`.
3. Copy the JSON response and paste it into the editor at https://editor.swagger.io.

## If time permits

4. Read up on Swagger Annotations at https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Annotations.
5. Try out a few of them. `@OpenApiDefinition`, `@Operation` and `@Parameter` are good candidates, but you can try some of the other ones as well.
6. Paste the updated `openapi.yaml` into the Swagger Editor to discover the behavior of these annotations.
