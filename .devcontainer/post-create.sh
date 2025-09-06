#!/bin/bash
# This script runs during the container creation process.

echo "--- post-create.sh starting at $(date) ---"

echo "Uninstalling AI assistant extensions..."
code --uninstall-extension GitHub.copilot --force
code --uninstall-extension GitHub.copilot-chat --force
code --uninstall-extension GitHub.copilot-labs --force
code --uninstall-extension TabNine.tabnine-vscode --force
code --uninstall-extension Codeium.codeium --force
code --uninstall-extension VisualStudioExptTeam.vscodeintellicode --force
echo "Extension uninstall commands executed."

echo "Making hide-copilot.sh executable..."
chmod +x .devcontainer/hide-copilot.sh
echo "Permissions set for hide-copilot.sh."

echo "--- post-create.sh finished at $(date) ---"

