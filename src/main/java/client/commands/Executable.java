package client.commands;

import common.Request;

public interface Executable {
    boolean execution(String[] args, Request request);
}
