import "@typespec/http";
import "@typespec/versioning";

using TypeSpec.Http;

model EventInput {
  name: "Evento na CESURG";
  description: "Aula com exercicios de CRUD com axios";
}

model ValidateNameEmpty {
  field: "name";
  errorMessage: "Preencha o nome, não pode ser vazio!";
}

model EventBadRequestBody {
  status: 400;
  message: "Validation Failed";
  timestamp: 1729109534426;
  errors: Array<ValidateNameEmpty>;
}

model EventBadRequest {
  ...BadRequestResponse;
  ...Body<EventBadRequestBody>;
}

model EventOutput {
  id: 1;
  name: "Evento na CESURG";
  description: "Aula com exercicios de CRUD com axios";
}

model EventListResponse {
  ...OkResponse,
  ...Body<Array<EventOutput>>
}

model EventCreatedResponse {
  ...CreatedResponse;
  ...Body<EventOutput>;
}

model EventOKResponse {
  ...OkResponse;
  ...Body<EventOutput>;
}

