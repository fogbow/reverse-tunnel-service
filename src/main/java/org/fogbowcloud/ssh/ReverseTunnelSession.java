package org.fogbowcloud.ssh;

import org.apache.sshd.common.SshConstants;
import org.apache.sshd.common.io.IoSession;
import org.apache.sshd.common.util.Buffer;
import org.apache.sshd.server.ServerFactoryManager;
import org.apache.sshd.server.session.ServerSession;

public class ReverseTunnelSession extends ServerSession {

	public ReverseTunnelSession(ServerFactoryManager server, IoSession ioSession)
			throws Exception {
		super(server, ioSession);
	}
	
	@Override
	protected void doHandleMessage(Buffer buffer) throws Exception {
		byte cmd = buffer.getByte();
		if (cmd == SshConstants.SSH_MSG_IGNORE) {
			resetIdleTimeout();
		}
		super.doHandleMessage(buffer);
	}

}
