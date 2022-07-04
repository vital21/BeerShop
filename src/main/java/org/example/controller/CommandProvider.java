package org.example.controller;

import java.util.Optional;

public class CommandProvider {
    public static Optional<CustomCommand> provider(String command) {
        Optional<CustomCommand> selectCommand;
        if (command != null && !command.isEmpty()) {
            try {
                CommandType commandType = CommandType.valueOf(command.toUpperCase());
                selectCommand = Optional.of(commandType.getCommand());
            } catch (IllegalArgumentException exception) {
                selectCommand = Optional.empty();
            }
        } else {
            selectCommand = Optional.empty();
        }
        return selectCommand;
    }
}
