#!/bin/bash

# Wait for VSCode to fully load
sleep 3

# Hide Copilot setup UI
code --command workbench.action.chat.hideSetup

echo "Copilot setup hidden"
