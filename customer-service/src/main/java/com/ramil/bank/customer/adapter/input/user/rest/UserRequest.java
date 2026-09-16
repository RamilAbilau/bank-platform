package com.ramil.bank.customer.adapter.input.user.rest;

import java.util.UUID;

public record UserRequest(UUID id, String name, String surname) {
}
