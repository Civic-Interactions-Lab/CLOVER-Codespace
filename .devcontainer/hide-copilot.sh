#!/bin/bash

# Wait for VSCode to fully load
sleep 5

# Create a user settings file to hide chat setup if it doesn't exist
mkdir -p ~/.vscode-server/data/User
SETTINGS_FILE=~/.vscode-server/data/User/settings.json

# Create or update user settings to hide chat setup
if [ -f "$SETTINGS_FILE" ]; then
    # If settings file exists, update it
    python3 -c "
import json
import sys

try:
    with open('$SETTINGS_FILE', 'r') as f:
        settings = json.load(f)
except:
    settings = {}

settings['chat.setupHidden'] = True
settings['github.copilot.enable'] = {'*': False}
settings['github.copilot.statusBarItem'] = False
settings['workbench.statusBar.feedback.visible'] = False

with open('$SETTINGS_FILE', 'w') as f:
    json.dump(settings, f, indent=2)
"
else
    # Create new settings file
    cat > "$SETTINGS_FILE" << 'EOF'
{
  "chat.setupHidden": true,
  "github.copilot.enable": {
    "*": false
  },
  "github.copilot.statusBarItem": false,
  "workbench.statusBar.feedback.visible": false
}
EOF
fi

echo "Chat setup hidden via user settings"
