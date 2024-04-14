package com.thomas.coins.infra;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ApiResponse<T> {
  
private String code; 
private String message;
private T data; 



}
