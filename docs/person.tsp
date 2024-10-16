import "@typespec/http";
import "@typespec/versioning";

using TypeSpec.Http;

model PersonInput {
  name: "Vinícius Boscardin";
}

model PersonBadRequestBody {
  status: 400;
  message: "Validation Failed";
  timestamp: 1729109534426;
  errors: Array<ValidateNameEmpty>;
}

model PersonBadRequest {
  ...BadRequestResponse;
  ...Body<PersonBadRequestBody>;
}

model PersonOutput {
  id: 1;
  name: "Vinícius Boscardin";
}

model PersonListResponse {
  ...OkResponse,
  ...Body<Array<PersonOutput>>
}

model PersonCreatedResponse {
  ...CreatedResponse;
  ...Body<PersonOutput>;
}

model PersonOKResponse {
  ...OkResponse;
  ...Body<PersonOutput>;
}

