# angry-atronach

Third year project.

The latest build can be viewed online at http://angry-atronach.herokuapp.com/

Please note that the server will take a moment to wake up after the first
attempt to access the application.

## Dependencies

- [activator](https://www.lightbend.com/activator/download)
- [neo4j community edition](http://neo4j.com/download/)
- [Heroku Toolbelt](https://toolbelt.heroku.com/), if you want to publish
  the project as an application on [heroku](https://www.heroku.com/).

Unfortunately, the login details for the local neo4j server are hard-coded into
the project at this time, so you'll have to set up the server to match. Take a
look at `repos.neo4j.SessionFactory`.

## Running Locally

Your neo4j server needs to be running. If you've set it up as a service, then
it should already be running.

```sh
$ activator run
```

The program should now be running on [localhost:9000](http://localhost:9000/).

## Running Tests

```sh
$ activator test
```

## Deploying to Heroku

```sh
$ heroku create
$ git push heroku master
$ heroku open
```
