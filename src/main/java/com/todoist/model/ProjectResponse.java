package com.todoist.model;


import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonInclude;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "color",
    "name",
    "comment_count",
    "shared",
    "favorite",
    "sync_id",
    "inbox_project",
    "url"
})
@Data
public class ProjectResponse {

  @JsonProperty("id")
  private Long id;
  @JsonProperty("color")
  private Integer color;
  @JsonProperty("name")
  private String name;
  @JsonProperty("comment_count")
  private Integer commentCount;
  @JsonProperty("shared")
  private Boolean shared;
  @JsonProperty("favorite")
  private Boolean favorite;
  @JsonProperty("sync_id")
  private Integer syncId;
  @JsonProperty("inbox_project")
  private Boolean inboxProject;
  @JsonProperty("url")
  private String url;

}
