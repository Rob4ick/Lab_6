package server.commands;

import common.Request;

public interface Executable {
    boolean execution(Request request);
}
