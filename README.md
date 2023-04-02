Results:

1. No streaming (test/list)

![obraz](https://user-images.githubusercontent.com/18016435/229362220-0da5e767-38df-4b8d-a68c-c7569e906103.png)


2. Streaming done exactly in jpa (test/stream) - seems like not working in postgres this way:

![obraz](https://user-images.githubusercontent.com/18016435/229362125-7f68924e-009b-4715-ba77-fe4257d9a203.png)


3. Streaming using entity manager - quite memory efficient (test/stream-new):

![obraz](https://user-images.githubusercontent.com/18016435/229361883-77add5c8-730b-41f4-a15f-1ec84dedc90d.png)



4. Streaming using entity manager with detatching - most memory efficient (test/stream-new-detatching):

![obraz](https://user-images.githubusercontent.com/18016435/229361465-5381e13b-d7b9-4097-9f90-49eb0082e108.png)
