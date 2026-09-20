package com.ramil.bank.customer.adapter.input.user.rest;

import java.util.UUID;

public record UserResponse(UUID id, String name, String surname) {
}
