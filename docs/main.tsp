import "@typespec/http";
import "@typespec/versioning";
import "./event.tsp";
import "./person.tsp";

using TypeSpec.Http;
using TypeSpec.Versioning;

@service({
  title: "API de Eventos",
})
@server("https://event-api.bosca.me", "Endpoint")
namespace EventsApi;

@route("/event")
@tag("Events")
namespace EventService {
  @get
  op fetch(): EventListResponse;

  @get
  @route("/{id}")
  op getByID(@path id: int32): EventOutput;

  @post
  op create(@body event: EventInput): EventCreatedResponse | EventBadRequest;

  @put
  @route("/{id}")
  op update(
    @path id: int32,
    @body event: EventInput,
  ): EventOKResponse | EventBadRequest;

  @delete
  @route("/{id}")
  op delete(@path id: int32): EventOKResponse;
}

@route("/person")
@tag("People")
namespace PersonService {
  @get
  op fetch(): PersonListResponse;

  @get
  @route("/{id}")
  op getByID(@path id: int32): PersonOutput;

  @post
  op create(@body person: PersonInput): PersonCreatedResponse | PersonBadRequest;

  @put
  @route("/{id}")
  op update(
    @path id: int32,
    @body person: PersonInput,
  ): PersonOKResponse | PersonBadRequest;

  @delete
  @route("/{id}")
  op delete(@path id: int32): PersonOKResponse;
}
