package server.commands;

import common.Request;
import common.Response;

public interface Executable {
    void execution(Request request, Response response);
}