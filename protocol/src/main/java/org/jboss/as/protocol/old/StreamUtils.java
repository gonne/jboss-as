/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2011, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.as.protocol.old;

import static org.jboss.as.protocol.ProtocolLogger.ROOT_LOGGER;

import javax.xml.stream.XMLStreamWriter;
import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
 *
 * @deprecated as of JBoss Application Server 7.1
 * @see org.jboss.as.protocol.StreamUtils
 */
@Deprecated
public class StreamUtils {

    /**
     * Safe close a {@code Closeable}.
     *
     * @param closeable the closeable to close
     * @deprecated as of JBoss Application Server 7.1
     * @see org.jboss.as.protocol.StreamUtils#safeClose(java.io.Closeable)
     */
    @Deprecated
    public static void safeClose(final Closeable closeable) {
        if (closeable != null) try {
            closeable.close();
        } catch (Throwable t) {
            ROOT_LOGGER.failedToCloseResource(t, closeable);
        }
    }

    /**
     * Safe close a {@code Socket}
     *
     * @param socket the socket to close
     * @deprecated as of JBoss Application Server 7.1
     * @see org.jboss.as.protocol.StreamUtils#safeClose(java.net.Socket)
     */
    @Deprecated
    public static void safeClose(final Socket socket) {
        if (socket != null) try {
            socket.close();
        } catch (Throwable t) {
            ROOT_LOGGER.failedToCloseResource(t, socket);
        }
    }

    /**
     * Safe close a {@code ServerSocket}.
     *
     * @param serverSocket the serverSocket to close
     * @deprecated as of JBoss Application Server 7.1
     * @see org.jboss.as.protocol.StreamUtils#safeClose(java.net.ServerSocket)
     */
    @Deprecated
    public static void safeClose(final ServerSocket serverSocket) {
        if (serverSocket != null) try {
            serverSocket.close();
        } catch (IOException e) {
            ROOT_LOGGER.failedToCloseServerSocket(e, serverSocket);
        }
    }

    /**
     * Safe close a {@code XmlStreamWriter}.
     *
     * @param writer the streamWriter to close.
     * @deprecated as of JBoss Application Server 7.1
     * @see org.jboss.as.protocol.StreamUtils#safeClose(javax.xml.stream.XMLStreamWriter)
     */
    @Deprecated
    public static void safeClose(final XMLStreamWriter writer) {
        if (writer != null) try {
            writer.close();
        } catch (Throwable t) {
            ROOT_LOGGER.failedToCloseResource(t, writer);
        }
    }

}
